import { UserType } from './UserType';
export class CustomerInfo {
    constructor(
        public userEmail:string,
        public displayName:string,
        public userFName:string,
        public userLName:string,
        public accumulatedPoints:number,
        public role:UserType,
        public userAddress:string,
        public userCity:string,
        public userState:string,
        public userZip:number,
    ) { }
}
