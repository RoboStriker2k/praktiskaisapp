import { Component } from '@angular/core';
import { computers } from '../types/types';

@Component({
  selector: 'addnewrecord',
  standalone : true,
  template: `
    <div class="addnewrecord">
      <h2>Add New Record</h2>
      <form group="newRecord">
        <label for="reason">Reason:</label>
        <input type="text" id="reason" name="reason" required />
        <label for="status">Status:</label>
        <input type="text" id="status" name="status" required />
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

        <button type="submit">Add Record</button>
      </form>
    </div>
  `,
})
export class AddNewRecordComponent {
  Computers: computers[] = [];
  async getcomputers() {
    const response = await fetch('/devices/getallcomputers');
    const data = await response.json();
    this.Computers = data;
  }

}
