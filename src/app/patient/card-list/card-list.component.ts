import {Component, Input, OnInit, Output, EventEmitter} from "@angular/core";
import {IPatient} from "../patient";
import {ICard} from "../card";
import {CardService} from "../services/card.service";

@Component({
  selector: 'patient-card-list',
  templateUrl: 'card-list.component.html',
})
export class PatientCardListComponent implements OnInit {

  constructor(private cardService: CardService) {
  }

  ngOnInit(): void {
    this.resetList();
  }

  @Input() patient: IPatient;

  cards: any;
  @Output() chosenCard: EventEmitter<any> = new EventEmitter<any>();

  showPatientList: boolean = true;

  ngAfterViewInit() {
    this.showPatientList = true;
  }

  onCardClicked(card: any): void {
    console.log("Wybrano dokumentacje o tytule " + card.documentation.title);
    console.log(card);
    this.chosenCard.emit(card);
  }

  resetList() {
    this.cardService.getCardList(this.patient)
      .subscribe((data) => this.cards = data);
  }

}
