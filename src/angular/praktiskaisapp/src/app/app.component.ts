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
} from '@components';

import { buttonstates } from './types/types';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    NavbarComponent,
    SearchbarComponent,
    ListingComponent,
    EmptyCardComponent,
    AddNewComputerComponent,
    AddNewRecordComponent,
    EditComputerComponent,
    DevicesListingComponent,

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
  };


  updatebtnstate(State: buttonstates) {
    this.buttonstates = State;
  }
  activeslot = 0

  editrecord(id: number) {
    console.log(id);
  }
}
