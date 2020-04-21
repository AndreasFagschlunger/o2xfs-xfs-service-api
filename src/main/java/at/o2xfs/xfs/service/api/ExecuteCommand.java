package at.o2xfs.xfs.service.api;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import at.o2xfs.xfs.api.XfsConstant;

public final class ExecuteCommand<E extends Enum<E> & XfsConstant> {

	public static class Builder<E extends Enum<E> & XfsConstant> {

		private final E command;
		private Optional<Object> cmdData;
		private OptionalInt timeOut;

		public Builder(E command) {
			this.command = Objects.requireNonNull(command);
			cmdData = Optional.empty();
			timeOut = OptionalInt.empty();
		}

		public Builder<E> cmdData(Object cmdData) {
			this.cmdData = Optional.ofNullable(cmdData);
			return this;
		}

		public Builder<E> timeOut(int timeOut) {
			this.timeOut = OptionalInt.of(timeOut);
			return this;
		}

		public ExecuteCommand<E> build() {
			return new ExecuteCommand<>(this);
		}
	}

	private final E command;
	private final Optional<Object> cmdData;
	private final OptionalInt timeOut;

	private ExecuteCommand(Builder<E> builder) {
		command = builder.command;
		cmdData = builder.cmdData;
		timeOut = builder.timeOut;
	}

	public E getCommand() {
		return command;
	}

	public Optional<Object> getCmdData() {
		return cmdData;
	}

	public OptionalInt getTimeOut() {
		return timeOut;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(command).append(cmdData).append(timeOut).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof ExecuteCommand) {
			ExecuteCommand<?> executeCommand = (ExecuteCommand<?>) obj;
			return new EqualsBuilder().append(command, executeCommand.command).append(cmdData, executeCommand.cmdData)
					.append(timeOut, executeCommand.timeOut).isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("command", command).append("cmdData", cmdData)
				.append("timeOut", timeOut).toString();
	}

	public static final <E extends Enum<E> & XfsConstant> ExecuteCommand<E> build(E command) {
		return new ExecuteCommand.Builder<>(command).build();
	}
}
