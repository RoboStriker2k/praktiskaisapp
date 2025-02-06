import { Component } from '@angular/core';
import { computers } from '../types/types';
@Component({
  selector: 'deviceslisting',
  standalone : true,
  template: `
    <div class="deviceslisting">
      @if (devices.length === 0) {
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
        </tr>

        @for ( device of devices ; track $index) {
        <tr>
          <th>{{ device.id }}</th>
          <th>{{ device.cpu }}</th>
          <th>{{ device.ramammount }}</th>
          <th>{{ device.gpu }}</th>
          <th>{{ device.motherboard }}</th>
          <th>{{ device.storageammount }}</th>
          <th>{{ device.comments }}</th>
          <th>{{ device.operatingsystem }}</th>
        </tr>
        }
      </table>
      }
    </div>
  `,
})
export class DevicesListingComponent {
  devices: computers[] = [];
  baseurl = window.location.origin;
  async getDevices() {
    const response = await fetch(`${this.baseurl}/computer/getallcomputers`);
    const data = await response.json();
    this.devices = data;
  }
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.getDevices();
  }
}
