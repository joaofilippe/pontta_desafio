import { CommonModule } from '@angular/common'
import { Component } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms'
import { RouterModule, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, RouterModule, CommonModule, ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'pontta-front';
}
