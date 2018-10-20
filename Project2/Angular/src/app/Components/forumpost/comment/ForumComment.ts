export class ForumComment{
    commentId:number;
    commentContent:string;

    constructor(commentId:number,commentContent:string){
        this.commentContent = commentContent;
        this.commentId = commentId;
    }
}