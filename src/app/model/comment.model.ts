export class Comment {
    id: number;
    name: string;
    email: string;
    comment: string;

    constructor(id: number, name: string, email: string, comment: string) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.comment = comment;
    }
}