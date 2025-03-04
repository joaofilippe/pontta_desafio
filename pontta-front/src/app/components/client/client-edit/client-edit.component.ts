import { CommonModule } from '@angular/common'
import { Component, OnInit } from '@angular/core'
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms'
import Client from '../../../services/model/client'
import { ClientService } from '../../../services/client.service'
import { ActivatedRoute, Router, RouterModule } from '@angular/router'

@Component({
  selector: 'app-client-edit',
  imports: [CommonModule, RouterModule, ReactiveFormsModule],
  templateUrl: './client-edit.component.html',
  styleUrl: './client-edit.component.css'
})
export class ClientEditComponent implements OnInit {
  client!: Client
  clientForm!: FormGroup
  clientId!: number

  constructor (
    private formBuilder: FormBuilder,
    private clientService: ClientService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    

    this.route.params.subscribe(
      params => {
        this.clientId = params['id']

        this.clientService.getById(this.clientId).subscribe({
          next: (data) => {
            this.client = data
            this.initForm()
          },
          error: (err) => {
            console.error('erro ao buscar o cliente:', err)
          }
        })
      }
    )
  }

  initForm() {
    this.clientForm = this.formBuilder.group({
      name: [this.client.name],
      email: [this.client.email],
      city: [this.client.city]
    })
  }

  onSubmit() {
    const updatedClient: Client = {
      id: this.clientId,
      ...this.clientForm.value
    }

    this.clientService.updateClient(this.clientId, updatedClient).subscribe({
      next: () => {
        this.router.navigate(['/client-edit'])
      },
      error: (err) => {
        console.error('Erro ao atualizar cliente:', err)
      }
    })



  }
}
