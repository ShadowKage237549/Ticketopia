export class CustomerInfo {
    constructor(
        public userEmail:string,
        public displayName:string,
        public password:string,
        public userFName:string,
        public userLName:string,
        public accumulatedPoints:number,
        public role:number,
        public userAddress:string,
        public userCity:string,
        public userState:string,
        public userZip:number,
    ) { }
}
