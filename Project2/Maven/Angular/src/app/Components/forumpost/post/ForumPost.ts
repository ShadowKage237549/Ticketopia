export class ForumPost {
    postId:number;
    postTitle:string;
    postContent:string;

    constructor(postId:number, postTitle:string, postContent:string){
        this.postId = postId;
        this.postContent = postContent;
        this.postTitle = postTitle;
    }
}