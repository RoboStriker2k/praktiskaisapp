import { Component } from '@angular/core';
import { computers } from '../types/types';

@Component({
  selector: 'addnewcomputer',
  standalone: true,
  template: `
    <div class="addnewcomputer">
      <form group="addnewcomputer">
        <label for="cpu">CPU:</label>
        <input type="text" id="cpu" name="cpu" required />

        <label for="ramammount">RAM:</label>
        <input type="number" id="ramammount" name="ramammount" required />

        <label for="gpu">GPU:</label>
        <input type="text" id="gpu" name="gpu" required />

        <label for="motherboard">Motherboard:</label>
        <input type="text" id="motherboard" name="motherboard" required />

        <label for="storageammount">Storage:</label>
        <input
          type="number"
          id="storageammount"
          name="storageammount"
          required
        />

        <label for="comments">Comments:</label>
        <input type="text" id="comments" name="comments" required />

        <label for="operatingsystem">Operating System:</label>
        <input
          type="text"
          id="operatingsystem"
          name="operatingsystem"
          required
        />

        <button preventDefault type="submit" (click)="submitfunction($event)">
          Submit
        </button>
      </form>
    </div>
  `,
})
export class AddNewComputerComponent {
  submitfunction(e: Event) {
    e.preventDefault();
    let computer = {
      cpu: '',
      ramAmmount: 0,
      gpu: '',
      motherboard: '',
      storageammount: 0,
      comments: '',
      operatingsystem: '',
    };
    computer = {
      cpu: (<HTMLInputElement>document.getElementById('cpu')).value,
      ramAmmount: parseInt(
        (<HTMLInputElement>document.getElementById('ramammount')).value
      ),
      gpu: (<HTMLInputElement>document.getElementById('gpu')).value,
      motherboard: (<HTMLInputElement>document.getElementById('motherboard'))
        .value,
      storageammount: parseInt(
        (<HTMLInputElement>document.getElementById('storageammount')).value
      ),
      comments: (<HTMLInputElement>document.getElementById('comments')).value,
      operatingsystem: (<HTMLInputElement>(
        document.getElementById('operatingsystem')
      )).value,
    };

    fetch('/computer/newcomputer', {
      method: 'POST',
      body: JSON.stringify(computer),
      headers: { 'Content-Type': 'application/json' },
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        window.alert('Computer added');
      });
  }
}
