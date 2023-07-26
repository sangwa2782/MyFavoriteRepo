package com.ajayam.mygit.data

class RepoData {
    var ownerName: String = ""
    var repoName: String = ""
    var description: String = ""
    var url: String = ""

    constructor(ownerName: String, repoName: String, url: String, description: String) {
        this.ownerName = ownerName
        this.repoName = repoName
        this.url = url
        this.description = description
    }


}