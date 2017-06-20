"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
var rxjs_1 = require("rxjs");
var CardService = (function () {
    function CardService(http) {
        this.http = http;
        this.url = "http://localhost:8080/patient/documentation/";
        this.documentationUrl = "http://localhost:8080/documentation/edit";
    }
    CardService.prototype.getCardList = function (patient) {
        console.log("Pobieram dokumentacje pacjenta " + patient.surname);
        return this.http
            .get(this.url + patient.id)
            .map(function (res) { return res.json(); })
            .catch(function (error) { return rxjs_1.Observable.throw(error.json() || "Server error"); });
    };
    CardService.prototype.editCard = function (editCard) {
        var body = editCard;
        var headers = new http_1.Headers();
        headers.append("content-type", 'application/json');
        headers.append("test", 'test');
        var url = "" + this.documentationUrl;
        console.log("Wysylam put pod url " + url);
        return this.http
            .put(url, body, headers)
            .map(function (res) { return res.json(); })
            .catch(function (error) { return rxjs_1.Observable.throw(error.json() || "Server error"); });
    };
    CardService = __decorate([
        core_1.Injectable()
    ], CardService);
    return CardService;
}());
exports.CardService = CardService;
