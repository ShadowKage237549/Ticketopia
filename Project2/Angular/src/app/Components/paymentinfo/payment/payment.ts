import { CustomerInfo } from './../../login/user/CustomerInfo';
export class Payment {
    constructor(
    public  customerInfo:CustomerInfo,
	public  cardNumber:string,
	public  securityCode:number,
	public  expirationDate:String,
	public  billingAddress:String,
	public  billingCity:String,
	public  billingState:String,
	public  billingZip:number,
){}
}