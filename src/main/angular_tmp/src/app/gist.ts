export class Gist {
  title: string;
  description: string;
  programmingLanguage: string;
  files: Array<File>;

  constructor() {
    this.title = '';
    this.description = '';
    this.programmingLanguage = '';
    this.files = new Array<File>();
  }
}

export class ServerGist {
  id: number;
  title: string;
  description: string;
  programmingLanguage: string;
  creationDate: string;
  files: Array<File>;
  starsCount: number;
}

export class File {
  fileName: string;
  code: string;

  constructor() {
    this.fileName = '';
    this.code = '';
  }
}
