import { Component } from '@angular/core';

@Component({
  selector: 'app-listings',
  standalone: true,
  template: `<div>
    <h1>Listing</h1>
<Table>
    <tr>
        <th>Name</th>
        <th>Price</th>
    </tr>
    @for (computer of dataprops.computers; track computer) {
       

            <tr>
                <td>{{computer.name}}</td>
                <td>{{computer.price}}</td>
       
   
    }
  </Table>

    <p>This is the listing page</p>
  </div> `,
})
export class ListingComponent {
    dataprops ={
        computers:[
            {name:"Dell",price:500},
        ]
    }
}
