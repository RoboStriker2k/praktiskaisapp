import { Component } from '@angular/core';
import { records } from '../types/types';
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
            </tr>
    }
    @if (records.length !== 0) {
    @for (record of records; track record) {
            <tr>
                <td>{{record.id}}</td>
                <td>{{record.requestdate}}</td>
                <td>{{record.requestedevices}}</td>
                <td>{{record.reason}}</td>
                <td>{{record.status}}</td>
                <td>{{record.requestor}}</td>
            </tr>
    }}
    @if (records.length === 0) {
        <tr>
            <td colspan="2">No records found</td>
        </tr>
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
  
    records : records[] = [];
    async getrecords (){
        const response = await fetch('/records/getallrecords');
        const data = await response.json();
        this.records = data;
    } 

}
