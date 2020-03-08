/*
 * This file is part of GriefDefender, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered <https://www.spongepowered.org>
 * Copyright (c) contributors
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
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.griefdefender.command;

import org.checkerframework.checker.nullness.qual.Nullable;

import net.kyori.text.Component;
import net.kyori.text.serializer.plain.PlainComponentSerializer;
import org.spongepowered.api.text.Text;

/**
 * A subclass of Exception that contains a rich message that is an instance of
 * {@link Text} rather than a String. This allows formatted and localized
 * exception messages.
 */
public class ComponentMessageException extends Exception {

    private static final long serialVersionUID = -5281221645176698853L;

    @Nullable private final Component message;

    /**
     * Constructs a new {@link ComponentMessageException}.
     */
    public ComponentMessageException() {
        this.message = null;
    }

    /**
     * Constructs a new {@link ComponentMessageException} with the given message.
     *
     * @param message The detail message
     */
    public ComponentMessageException(Component message) {
        this.message = message;
    }

    /**
     * Constructs a new {@link ComponentMessageException} with the given message and
     * cause.
     *
     * @param message The detail message
     * @param throwable The cause
     */
    public ComponentMessageException(Component message, Throwable throwable) {
        super(throwable);
        this.message = message;
    }

    /**
     * Constructs a new {@link ComponentMessageException} with the given cause.
     *
     * @param throwable The cause
     */
    public ComponentMessageException(Throwable throwable) {
        super(throwable);
        this.message = null;
    }

    @Override
    @Nullable
    public String getMessage() {
        Component message = getText();
        return message == null ? null : PlainComponentSerializer.INSTANCE.serialize(message);
    }

    /**
     * Returns the text message for this exception, or null if nothing is
     * present.
     * 
     * @return The text for this message
     */
    @Nullable
    public Component getText() {
        return this.message;
    }

    @Override
    @Nullable
    public String getLocalizedMessage() {
        return getMessage();
    }
}
