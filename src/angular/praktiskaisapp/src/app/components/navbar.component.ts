import { Component } from '@angular/core';

@Component({
  selector: 'app-navbar',
  standalone: true,

  styleUrls: ['./navbar.css'],
  template: `
    <div class="navbar">
      
        <div class="navbar-header">
          <a href="#" class="navbar-brand">{{ title }}</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
          </ul>
        </div>
   
    </div>
  `,
})
export class NavbarComponent {
  title = 'praktiskaisapp';
}
