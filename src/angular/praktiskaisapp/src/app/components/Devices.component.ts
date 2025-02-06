import { Component, Input } from "@angular/core";
import { computers } from "../types/types";

@Component  ({
    selector: "Devicetable",
    standalone: true,
    template: `<table>
    <tr>
       @if (devices.length !== 0) { @for (device of devices; track device) {
       <td>{{ device.cpu }}</td>
       <td>{{ device.ramammount }}</td>
       <td>{{ device.gpu }}</td>
       <td>{{ device.motherboard }}</td>
       <td>{{ device.storageammount }}</td>
       <td>{{ device.comments }}</td>
       <td>{{ device.operatingsystem }}</td>
       }} @if (devices.length === 0) {
       <td colspan="7">No devices found</td>
       }
    </tr>

  </table>`,
  })
  export class DevicesComponent {
    @Input() requestedevices: number[] = [];
     devices: computers[] = [];
    baseurl = window.location.origin;
    async getdevicebyid(id: number) {
        const response = await fetch(`${this.baseurl}/computer/getcomputer/${id}`);
        const data = await response.json();
        return data;
      }

      async getdevices() {
        for (let i = 0; i < this.requestedevices.length; i++) {
          this.devices.push(await this.getdevicebyid(this.requestedevices[i]));
        }
      }
      ngOnInit(): void {
        //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
        //Add 'implements OnInit' to the class.
        this.getdevices();
      }
  }