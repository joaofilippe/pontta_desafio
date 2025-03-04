import { HttpClient, HttpErrorResponse } from '@angular/common/http'
import { Injectable } from '@angular/core'
import Client from './model/client'
import { Observable } from 'rxjs/internal/Observable'
import { catchError, throwError } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private baseUrl: string = "http://localhost:8080"

  constructor (
    private http: HttpClient
  ) { }

  getAllClients(): Observable<Client[]> {
    return this.http.get<Client[]>(`${this.baseUrl}/client`)
  }

  getById(id: number) : Observable<Client>{
    return this.http.get<Client>(`${this.baseUrl}/client/${id}`)
  }

  updateClient(id: number, client : Client): Observable<Client> {
    const result = this.http.put<Client>(`${this.baseUrl}/client/${id}`, client).pipe(
      catchError(
        this.handleError
      )
    )
    return result
  }

  deleteClient(id: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}/client/${id}`)
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error('Ocorreu um erro:', error.error.message)
    } else {
      console.error(
        `Code ${error.status}, ` +
        `Message: ${error.error}`)
    }
    return throwError(() => new Error('Algo deu errado; por favor, tente novamente mais tarde.'))
  }
}
