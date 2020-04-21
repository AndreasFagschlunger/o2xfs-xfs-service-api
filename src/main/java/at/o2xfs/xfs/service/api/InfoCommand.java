package at.o2xfs.xfs.service.api;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.xfs.api.XfsConstant;

public final class InfoCommand<E extends Enum<E> & XfsConstant> {

	public static class Builder<E extends Enum<E> & XfsConstant> {

		private final E category;
		private Optional<Object> queryDetails;
		private OptionalInt timeOut;

		public Builder(E category) {
			this.category = Objects.requireNonNull(category);
			queryDetails = Optional.empty();
			timeOut = OptionalInt.empty();
		}

		public Builder<E> queryDetails(Object queryDetails) {
			this.queryDetails = Optional.ofNullable(queryDetails);
			return this;
		}

		public Builder<E> timeOut(int timeOut) {
			this.timeOut = OptionalInt.of(timeOut);
			return this;
		}

		public InfoCommand<E> build() {
			return new InfoCommand<>(this);
		}
	}

	private final E category;
	private final Optional<Object> queryDetails;
	private final OptionalInt timeOut;

	private InfoCommand(Builder<E> builder) {
		category = builder.category;
		queryDetails = builder.queryDetails;
		timeOut = builder.timeOut;
	}

	public E getCategory() {
		return category;
	}

	public Optional<Object> getQueryDetails() {
		return queryDetails;
	}

	public OptionalInt getTimeOut() {
		return timeOut;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(category).append(queryDetails).append(timeOut).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof InfoCommand) {
			InfoCommand<?> infoCommand = (InfoCommand<?>) obj;
			return new EqualsBuilder().append(category, infoCommand.category)
					.append(queryDetails, infoCommand.queryDetails).append(timeOut, infoCommand.timeOut).isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("category", category).append("queryDetails", queryDetails)
				.append("timeOut", timeOut).toString();
	}

	public static final <E extends Enum<E> & XfsConstant> InfoCommand<E> build(E category) {
		return new InfoCommand.Builder<>(category).build();
	}
}
