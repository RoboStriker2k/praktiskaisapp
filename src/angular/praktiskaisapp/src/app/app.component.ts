import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from "./components/navbar.component";
import { SearchbarComponent } from "./components/searchbar.component";
import { ListingComponent } from "./components/listing.component";
import { AddNewComputerComponent } from "./components/addnewcomputer.component";
import { AddNewRecordComponent } from "./components/addRecord.component";
import { EmptyCardComponent } from './components/Emptycard.component';
import { DevicesListingComponent } from './components/DevicesListing.component';
import { EditComputerComponent } from './components/EditComputer.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavbarComponent, SearchbarComponent, ListingComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'praktiskaisapp';
  buttonstates = {
    addbutton: false,
    editbutton: false,
    deletebutton: false,
    listcomputers: false,
    addrecords: false,
  }
  slotfiller = {
    0: EmptyCardComponent,
    1: AddNewComputerComponent,
    2: AddNewRecordComponent,
    3: EditComputerComponent, 
    4: DevicesListingComponent
  }

  activeslot = this.slotfiller[0];
  updateActiveSlot() {
    if (this.buttonstates.addbutton) {
      this.activeslot = this.slotfiller[1];
    } else if (this.buttonstates.editbutton) {
      this.activeslot = this.slotfiller[2];
    } else if (this.buttonstates.listcomputers) {
      this.activeslot = this.slotfiller[3];
    } else if (this.buttonstates.addrecords) {
      this.activeslot = this.slotfiller[4];
    } else {
      this.activeslot = this.slotfiller[0];
    }
  }
  editrecord(id: number) {
    console.log(id);
  }
}
