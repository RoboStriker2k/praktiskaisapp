import { Component, EventEmitter, Input, Output } from '@angular/core';
import { records } from '../types/types';

@Component({
  selector: 'app-editrecord',
  standalone: true,
  template: `
    <div class="editrecord">
      <h2>Edit Record</h2>
      <form group="computer">
        <p>Computer ID: {{ record.id }}</p>
        <p>Request Date: {{ record.requestdate }}</p>
        <p>Requestor: {{ record.requestor }}</p>
        <input
          type="text"
          id="requestor"
          [value]="record.requestor"
          (change)="onchange($event)"
        />
        <p>Reason: {{ record.reason }}</p>
        <input
          type="text"
          id="reason"
          [value]="record.reason"
          (change)="onchange($event)"
        />
        <select id="status" (change)="updatestatus(record.id, $event)">
          <option value="{{ record.status }}">{{ record.status }}</option>
          <option value="Pending">Pending</option>
          <option value="Approved">Approved</option>
          <option value="Denied">Denied</option>
        </select>

        <div>
          <button preventDefault (click)="saveRecord($event)">Save</button>
          <button preventDefault (click)="cancel()">Cancel</button>
        </div>
      </form>
    </div>
  `,
})
export class EditRecordComponent {
  cancel() {
    this.closeedit.emit(true);
  }
  @Output() closeedit = new EventEmitter<boolean>();
  @Input() id = 0;
  record: records = {
    id: 0,
    requestdate: '',
    requestedevices: [],
    reason: '',
    status: '',
    requestor: '',
    devices: [],
  };

  onchange(event: Event) {
    this.record = {
      ...this.record,
      [(event.target as HTMLInputElement).id]: (
        event.target as HTMLInputElement
      ).value,
    };
  }
  async getRecord() {
    const response = fetch(`/records/Findbyid/${this.id}`)
      .then((response) => response.json())
      .then((data) => (this.record = data))
      .then(() => console.log(this.record));
  }
  async saveRecord(e: Event) {
    e.preventDefault();
    const response = await fetch(`/records/updaterecord/${this.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(this.record),
    });
    const data = await response.json();
    console.log(data);
  }
  updatestatus( id: number, event: any) {
    const status = event.target.value

   this.record.status = status
  }
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
    this.getRecord();
  }
}
