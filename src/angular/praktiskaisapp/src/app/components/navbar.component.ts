import { Component, Output } from '@angular/core';
import { buttonstates } from '../types/types';

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
            <button name="addbutton" (click)="changestate($event)">
              Add Computers
            </button>
          </tr>
          <tr>
            <button name="addrecords" (click)="changestate($event)">
              Add Records
            </button>
          </tr>
          <tr>
            <button name="editbutton" (click)="changestate($event)">
              Edit Computers
            </button>
          </tr>
          <tr>
            <button name="deletebutton" (click)="changestate($event)">
              Delete Computers
            </button>
          </tr>
          <tr>
            <button name="listcomputers" (click)="changestate($event)">
              List Computers
            </button>
          </tr>
        </ul>
      </div>
    </div>
  `,
})
export class NavbarComponent {
  title = 'praktiskaisapp';
  @Output() buttonstates: buttonstates = {
    addbutton: false,
    editbutton: false,
    deletebutton: false,
    listcomputers: false,
    addrecords: false,
  };
  changestate(event: any) {

    let buttname = event.target.name as keyof typeof this.buttonstates;
    if (
      typeof buttname === 'string' &&
      [
        'addbutton',
        'editbutton',
        'deletebutton',
        'listcomputers',
        'addrecords',
      ].includes(buttname)
    ) {
      console.log('hi event.target.name : ', event.target.name, this.buttonstates);

        
      
      (prev: buttonstates) => {
        this.buttonstates = {
          ...prev,
          [buttname]: !prev[buttname] ,
        };
    
      }
    } else {
      console.log(' hi 2 event.target.name : ', event.target.name);
      this.buttonstates = {
        addbutton: false,
        editbutton: false,
        deletebutton: false,
        listcomputers: false,
        addrecords: false,
      };
    }
  }
}
