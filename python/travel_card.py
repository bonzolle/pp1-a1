from dataclasses import dataclass


@dataclass
class TravelCard:
    number: int
    balance: int


card = TravelCard(1001, 50)
card.balance -= 80   # ingen protesterar
print(card)          # TravelCard(number=1001, balance=-30)
