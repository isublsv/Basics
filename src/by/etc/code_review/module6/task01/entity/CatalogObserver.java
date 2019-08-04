package by.etc.code_review.module6.task01.entity;

import by.etc.code_review.module6.task01.entity.book.Book;
import by.etc.code_review.module6.task01.entity.user.Email;
import by.etc.code_review.module6.task01.utils.Operation;

public interface CatalogObserver {

	void update(Operation operation, Book book, Email email);
}
