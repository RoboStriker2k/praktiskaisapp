import { Component } from '@angular/core';
import { computers } from '../types/types';

@Component({
  selector: 'addnewrecord',
  standalone: true,
  template: `
    <div class="addnewrecord">
      <h2>Add New Record</h2>
      <form group="newRecord">
        <label for="reason">Reason:</label>
        <input type="text" id="reason" name="reason" required />
        <label for="status">Status:</label>
        <input
          type="text"
          id="status"
          name="status"
          required
          [defaultValue]="'Pending'"
        />
        <p>Devices to Request</p>
        @if (Computers.length === 0) {
        <p>No devices found</p>
        } @else {
        <table>
          <tr>
            <th>ID</th>
            <th>CPU</th>
            <th>RAM</th>
            <th>GPU</th>
            <th>Motherboard</th>
            <th>Storage</th>
            <th>Comments</th>
            <th>Operating System</th>
            <th>Ammount</th>
          </tr>

          @for ( device of Computers ; track $index) {
          <tr>
            <th>{{ device.id }}</th>
            <th>{{ device.cpu }}</th>
            <th>{{ device.ramammount }}</th>
            <th>{{ device.gpu }}</th>
            <th>{{ device.motherboard }}</th>
            <th>{{ device.storageammount }}</th>
            <th>{{ device.comments }}</th>
            <th>{{ device.operatingsystem }}</th>
            <input name="Ammount" [id]="device.id" type="number" />
          </tr>
          }
        </table>
        }

        <button type="submit" preventDefault (click)="onSubmit($event)">
          Add Record
        </button>
      </form>
    </div>
  `,
})
export class AddNewRecordComponent {
  Computers: computers[] = [];
  baseurl = window.location.origin;

  async getcomputers() {
    const response = await fetch(`${this.baseurl}/computer/getallcomputers`);
    const data = await response.json();
    this.Computers = data;
  }

  onSubmit(e: Event) {
    e.preventDefault();
    let requestedevices: Number[] = [];
    this.Computers.forEach((element) => {
      let ammount = (<HTMLInputElement>(
        document.getElementById(element.id.toString())
      )).value;
      if (ammount !== '') {
        for (let i = 0; i < parseInt(ammount); i++) {
          requestedevices.push(element.id);
        }
      }
    });

    let request = {
      reason: (<HTMLInputElement>document.getElementById('reason')).value,
      status: (<HTMLInputElement>document.getElementById('status')).value,
      requestedevices: requestedevices,
    };
    fetch(`${this.baseurl}/records/newrecord`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(request),
    })
      .then((response) => response.json())
      .then((data) => {
        alert('Record added successfully!');
        this.getcomputers();
      });
  }

  ngOnInit(): void {
    this.getcomputers();
  }
}
