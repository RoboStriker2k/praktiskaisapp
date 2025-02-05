import { Component, Output   } from '@angular/core';

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
        <ul class="navbtns">
          <tr>
            <button>Add Computers</button>
          </tr>
          <tr>
            <button>Edit Computers</button>
          </tr>
          <tr>
            <button>Delete Computers</button>
          </tr>
          <tr>
            <button>Add Records</button>
          </tr>
          <tr>
            <button>Edit Records</button>
          </tr>
          <tr>
            <button>Delete Records</button>
          </tr>
        </ul>
      </div>
    </div>
  `,
})
export class NavbarComponent {
  title = 'praktiskaisapp';
  @Output() buttonstates = {
    addbutton: false,
    editbutton: false,
    deletebutton: false,
    savebutton: false,
  };

}
