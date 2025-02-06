import { Component, EventEmitter, Input, Output, output } from '@angular/core';
import { computers } from '../types/types';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-edit-computer',
  standalone: true,
  template: `
    <div class="edit-computer">
      <h2>Edit Computer</h2>
      <form group="computer">
        <p>Computer ID: {{ computer.id }}</p>
        <input
          type="hidden"
          id="id"
          [value]="computer.id"
          (change)="onchange($event)"
        />
        <label for="cpu">CPU</label>
        <input
          type="text"
          id="cpu"
          [value]="computer.cpu"
          (change)="onchange($event)"
        />
        <label for="ram">RAM</label>
        <input
          type="number"
          id="ramAmmount"
          [value]="computer.ramAmmount"
          (change)="onchange($event)"
        />
        <label for="gpu">GPU</label>
        <input
          type="text"
          id="gpu"
          [value]="computer.gpu"
          (change)="onchange($event)"
        />
        <label for="motherboard">Motherboard</label>
        <input
          type="text"
          id="motherboard"
          [value]="computer.motherboard"
          (change)="onchange($event)"
        />
        <label for="storage">Storage</label>
        <input
          type="number"
          id="storage"
          [value]="computer.storageammount"
          (change)="onchange($event)"
        />
        <label for="comments">Comments</label>
        <input
          type="text"
          id="comments"
          [value]="computer.comments"
          (change)="onchange($event)"
        />
        <label for="operatingsystem">Operating System</label>
        <input
          type="text"
          id="operatingsystem"
          [value]="computer.operatingsystem"
          (change)="onchange($event)"
        />
        <div>
          <button preventDefault (click)="saveComputer($event)">Save</button>
          <button preventDefault (click)="cancel()">Cancel</button>
        </div>
      </form>
    </div>
  `,
})
export class EditComputerComponent {
  cancel() {
    this.closeedit.emit(true);
  }
  @Output() closeedit = new EventEmitter<boolean>();
  @Input() id = 0;
  computer: computers = {
    id: 0,
    cpu: '',
    ramAmmount: 0,
    gpu: '',
    motherboard: '',
    storageammount: 0,
    comments: '',
    operatingsystem: '',
  };

  onchange(event: Event) {
    this.computer = {
      ...this.computer,
      [(event.target as HTMLInputElement).id]: (
        event.target as HTMLInputElement
      ).value,
    };
  }
  async getComputer() {
    const response = fetch(`/computer/getcomputer/${this.id}`)
      .then((response) => response.json())
      .then((data) => (this.computer = data))
      .then(() => console.log(this.computer));
  }
  async saveComputer(e: Event) {
    e.preventDefault();
    const response = await fetch(`/computer/updatecomputer/${this.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(this.computer),
    });
    const data = await response.json();
    console.log(data);
  }
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.getComputer();
  }
}
