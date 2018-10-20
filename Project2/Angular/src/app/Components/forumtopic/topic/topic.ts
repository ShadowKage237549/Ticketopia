export class Topic{
    topicId:number;
    topicName:string;
    topicDescription:string;
    
    constructor(topicId:number, topicName:string, topicDescription:string){
        this.topicId=topicId;
        this.topicName=topicName;
        this.topicDescription=topicDescription;
    }
}