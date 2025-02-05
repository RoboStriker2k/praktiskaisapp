import { Component } from "@angular/core";

@Component({
    selector: 'addnewcomputer', 
    template:`
        <div class="addnewcomputer">
            <form>
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>

                <label for="price">Price:</label>
                <input type="number" id="price" name="price" required>

                <button type="submit">Add Computer</button>
            </form>
        </div>
    `
})
export class AddNewComputerComponent {
    
}