import { Component } from "@angular/core";

@Component ({
    selector: "app-searchbar",
    standalone: true,
    template: `
        <div class="searchbar">

        
        <input type="text" placeholder="Search...">
        <button>Search</button>
        </div>
    `
    })  
export class SearchbarComponent {}
