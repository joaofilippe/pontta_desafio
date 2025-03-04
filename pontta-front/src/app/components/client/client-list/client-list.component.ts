import { Component, OnInit } from '@angular/core'
import { Router, RouterModule } from '@angular/router'
import { ClientService } from '../../../services/client.service'
import Client from '../../../services/model/client'
import { CommonModule } from '@angular/common'

@Component({
  selector: 'app-client-list',
  imports: [CommonModule, RouterModule],
  templateUrl: './client-list.component.html',
  styleUrl: './client-list.component.css'
})
export class ClientListComponent implements OnInit {
  public clients : Client[] = []
  public loading: boolean = true
  public error: boolean = false

  constructor (
    private clientService: ClientService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.clientService.getAllClients().subscribe({
      next: (data) => {
        this.clients = data
        this.loading = false
        this.error = false
      }, 
      error: (err) => {
        console.error("não foi possível fazer get da lista de usuários:", err)
        this.loading = false
        this.error = true
      }
    })
  }

  navigateToEdit(id: number): void {
    this.router.navigate(['client', id])
  }

  onDeleteClick(id: number) {
    this.clientService.deleteClient(id).subscribe({
      next: () => {
        console.log("Cliente deletado com sucesso")
        this.clientService.getAllClients()
      },
      error: (err) => {
        console.error(err)
      }
    })

    this.router.navigate(['/client'])
  }
}
