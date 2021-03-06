/* Copyright (c) 2019 LibJ
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * You should have received a copy of The MIT License (MIT) along with this
 * program. If not, see <http://opensource.org/licenses/MIT/>.
 */

package org.libj.util.function;

import java.util.Objects;
import java.util.function.<X>Consumer;

/**
 * Represents an operation that accepts three {@code <x>}-valued arguments and
 * returns no result. This is the three-arity specialization of
 * {@link <X>Consumer}. Unlike most other functional interfaces,
 * {@link Tri<X>Consumer} is expected to operate via side-effects.
 *
 * @see <X>Consumer
 */
@FunctionalInterface
public interface Tri<X>Consumer {
  /**
   * Performs this operation on the given argument.
   *
   * @param v1 The first input argument.
   * @param v2 The second input argument.
   * @param v3 The third input argument.
   */
  void accept(<x> v1, <x> v2, <x> v3);

  /**
   * Returns a composed {@link Tri<X>Consumer} that performs, in sequence, this
   * operation followed by the {@code after} operation. If performing either
   * operation throws an exception, it is relayed to the caller of the composed
   * operation. If performing this operation throws an exception, the
   * {@code after} operation will not be performed.
   *
   * @param after The operation to perform after this operation.
   * @return A composed {@link Tri<X>Consumer} that performs in sequence this
   *         operation followed by the {@code after} operation.
   * @throws NullPointerException If {@code after} is null.
   */
  default Tri<X>Consumer andThen(final Tri<X>Consumer after) {
    Objects.requireNonNull(after);
    return (v1, v2, v3) -> {
      accept(v1, v2, v3);
      after.accept(v1, v2, v3);
    };
  }
}