import { Component, EventEmitter, Output } from '@angular/core';
import { records } from '../types/types';
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
        <td>{{ record.requestedevices }}</td>
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
})
export class ListingComponent {
  dataprops = {
    computers: [{ name: 'Dell', price: 500 }],
  };

  records: records[] = [];
  async getrecords() {
    const response = await fetch('/records/getallrecords');
    const data = await response.json();
    this.records = data;
  }
  @Output() editrecord = new EventEmitter<number>();
    delete(id: number) {
        fetch(`/records/deleterecord/${id}`, { method: 'DELETE' })
        .then(response => response.json())
        .then(data => {
          console.log(data);
        })
        .catch(error => console.error('Error:', error));
    }
}
