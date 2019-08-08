package by.epam.code_review.module5.oop.task05.factory;

import by.epam.code_review.module5.oop.task05.entity.Color;
import by.epam.code_review.module5.oop.task05.entity.flower.Piony;
import by.epam.code_review.module5.oop.task05.entity.flower.Rose;
import by.epam.code_review.module5.oop.task05.entity.flower.Tulip;

public interface FlowerAbstractFactory {

	Rose createRose(Color color);

	Tulip createTulip(Color color);

	Piony createPiony(Color color);
}
