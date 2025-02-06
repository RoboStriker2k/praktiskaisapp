import { Component, EventEmitter, Output } from '@angular/core';
import { computers, records } from '../types/types';
import { DevicesComponent } from "./Devices.component";

@Component({
  selector: 'app-listings',
  standalone: true,
  template: `<div>
    <h1>Listing</h1>
    <Table>
      <tr>
        <th>ID</th>
        <th>Request Date</th>
        <th>Requested Devices</th>
        <th>Reason</th>
        <th>Status</th>
        <th>Requestor</th>
        <th>Actions</th>
      </tr>
      @if (records.length !== 0) { @for (record of records; track record) {
      <tr>
        <td>{{ record.id }}</td>
        <td>{{ record.requestdate }}</td>
        <td>
          @if (record.requestedevices !== null) {
        <Devicetable [requestedevices]="record.requestedevices"></Devicetable>
          } @else {
            <p>No devices requested</p>
          }
      </td>
        <td>{{ record.reason }}</td>
        <td>{{ record.status }}</td>
        <td>{{ record.requestor }}</td>
        <td><button (click)="editrecord.emit(record.id)">Edit</button></td>
        <td><button (click)="delete(record.id)">Delete</button></td>
      </tr>
      }} @if (records.length === 0) {
      <tr>
        <td colspan="2">No records found</td>
      </tr>
      }
    </Table>
  </div> `,
  imports: [DevicesComponent],
})
export class ListingComponent {

  records: records[] = [];
  baseurl = window.location.origin;
  async getrecords() {
    const response = await fetch(`${this.baseurl}/records/getallrecords`);
    const data = await response.json();
    
  this.records = data;
}

  async getdevicebyid(id: number) {
    const response = await fetch(`${this.baseurl}/computer/getcomputer/${id}`);
    const data = await response.json();
    return data;
  }
  @Output() editrecord = new EventEmitter<number>();
  delete(id: number) {
    fetch(`${this.baseurl}/records/deletebyid/${id}`, { method: 'DELETE' })
      .then(() => this.getrecords());
  }
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.getrecords();
  }
}
