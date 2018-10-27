export class Ticket {
    constructor(
        public ticketId: number,
        public ticketType: string,
        public ticketPrice: number,
        public eventType: string,
        public eventDescription: string,
        public eventAddress: string,
        public eventCity: string,
        public eventState: string,
        public eventZip: number,
        public partnerName: string,
        public topicId: number,
        public freeFlag: boolean) { }
}
