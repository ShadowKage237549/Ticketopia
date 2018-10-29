import { CustomerInfo } from '../../login/user/CustomerInfo';
export class Payment {
    customerInfo: CustomerInfo;
    cardNumber: number;
    securityCode: number;
    expirationDate: String;
    billingAddress: String;
    billingCity: String;
    billingState: String;
    billingZip: number;
}
