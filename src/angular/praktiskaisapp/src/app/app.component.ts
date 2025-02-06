import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {
  NavbarComponent,
  ListingComponent,
  EditComputerComponent,
  DevicesListingComponent,
  AddNewComputerComponent,
  AddNewRecordComponent,
  EmptyCardComponent,
  SearchbarComponent,
  EditRecordComponent,
} from '@components';

import { buttonstates } from './types/types';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    NavbarComponent,
    ListingComponent,
    EmptyCardComponent,
    AddNewComputerComponent,
    AddNewRecordComponent,
    EditComputerComponent,
    DevicesListingComponent,
    EditRecordComponent,

  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'praktiskaisapp';

  buttonstates = {
    addbutton: false,
    editbutton: false,
    deletebutton: false,
    listcomputers: false,
    addrecords: false,
    editrecord: false,
  };


  updatebtnstate(State: buttonstates) {
    this.buttonstates = State;
  }
  activeslot = 0
editableid=0
editcomputer(id: number) {
  this.editableid=id
  this.updatebtnstate({ ...this.buttonstates, editbutton: true });
}
  editrecord(id: number) {
    this.editableid=id
    this.updatebtnstate({ ...this.buttonstates, editrecord: true });
  }
}
