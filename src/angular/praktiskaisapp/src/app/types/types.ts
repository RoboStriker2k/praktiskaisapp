export type records = {
  id: number;
  requestdate: string;
  requestedevices:number[];
  devices: computers[];
  reason: string;
  status: string;
  requestor: string;
};
export type computers = {
  id: number ;
  cpu: string;
  ramammount: number; 
  gpu: string;
  motherboard: string;
  storageammount: number;
  comments: string;
  operatingsystem: string;
};

export type buttonstates = {
  addbutton: boolean;
  editbutton: boolean;
  deletebutton: boolean;
  listcomputers: boolean;
  addrecords: boolean;
};