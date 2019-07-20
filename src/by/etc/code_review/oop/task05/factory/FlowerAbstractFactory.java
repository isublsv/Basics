package by.etc.code_review.oop.task05.factory;

import by.etc.code_review.oop.task05.entity.Color;
import by.etc.code_review.oop.task05.entity.flower.Piony;
import by.etc.code_review.oop.task05.entity.flower.Rose;
import by.etc.code_review.oop.task05.entity.flower.Tulip;

public interface FlowerAbstractFactory {

	Rose createRose(Color color);

	Tulip createTulip(Color color);

	Piony createPiony(Color color);
}
