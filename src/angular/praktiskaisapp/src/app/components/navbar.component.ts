import { Component,  EventEmitter, Output, signal } from '@angular/core';
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
 buttonstates: buttonstates = {
    addbutton: false,
    editbutton: false,
    deletebutton: false,
    listcomputers: false,
    addrecords: false,
    editrecord: false,
  };
  defaultbtnstates: buttonstates = {
    addbutton: false,
    editbutton: false,
    deletebutton: false,
    listcomputers: false,
    addrecords: false,
    editrecord: false,
  };

  buttons = signal<buttonstates>(this.buttonstates);
@Output () BTNStates= new EventEmitter<buttonstates>();
  changestate(event: any) {
    let buttname = event.target.name as keyof typeof this.buttonstates;
    if (
      [
        'addbutton',
        'editbutton',
        'deletebutton',
        'listcomputers',
        'addrecords',
        'editrecord',
      ].includes(buttname)
    ) {
      this.buttons.update((state) => ({
        ...state,
        ...this.defaultbtnstates,
        [buttname]: !state[buttname],
      }));
      this.BTNStates.emit(this.buttons());
    } else {
      this.buttons.update((state: any) => ({
        ...state,
        ...this.defaultbtnstates,
      }));
    

    }
 
  }
}
