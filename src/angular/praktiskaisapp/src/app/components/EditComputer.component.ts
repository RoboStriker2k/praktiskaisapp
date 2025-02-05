import { Component, Input } from '@angular/core';
import { computers } from '../types/types';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-edit-computer',
  standalone : true,
  template: `
    <div class="edit-computer">
      <h2>Edit Computer</h2>
       <form group="computer">
            <p>Computer ID: {{ computer.id }}</p>
            <input type="hidden" id="id" [value]="computer.id" />
            <label for="cpu">CPU</label>
            <input type="text" id="cpu" [value]="computer.cpu" />
            <label for="ram">RAM</label>
            <input type="number" id="ram" [value]="computer.ramammount" />
            <label for="gpu">GPU</label>
            <input type="text" id="gpu" [value]="computer.gpu" />
            <label for="motherboard">Motherboard</label>
            <input type="text" id="motherboard" [value]="computer.motherboard" />
            <label for="storage">Storage</label>
            <input type="number" id="storage" [value]="computer.storageammount" />
            <label for="comments">Comments</label>
            <input type="text" id="comments" [value]="computer.comments" />
            <label for="operatingsystem">Operating System</label>
            <input type="text" id="operatingsystem" [value]="computer.operatingsystem" />
            <button (click)="saveComputer()">Save</button>
        </form>
    </div>
  `,
})
export class EditComputerComponent {
  @Input() id = 0;
  computer: computers = {
    id: 0,
    cpu: '',
    ramammount: 0,
    gpu: '',
    motherboard: '',
    storageammount: 0,
    comments: '',
    operatingsystem: '',
    };

  async getComputer() {
    const response = fetch(`/devices/getcomputer/${this.id}`)
      .then((response) => response.json())
      .then((data) => (this.computer = data));
  }
  async saveComputer() {
    const response = await fetch(`/devices/updatecomputer/${this.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(this.computer),
    });
    const data = await response.json();
    console.log(data);
  }
}
