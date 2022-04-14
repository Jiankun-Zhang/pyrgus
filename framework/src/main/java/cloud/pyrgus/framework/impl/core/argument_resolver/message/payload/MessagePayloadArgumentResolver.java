/*
 * MIT License
 *
 * Copyright (c) 2022 Zhang Jiankun
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cloud.pyrgus.framework.impl.core.argument_resolver.message.payload;

import cloud.pyrgus.framework.core.message.Message;
import cloud.pyrgus.framework.impl.core.argument_resolver.ArgumentResolver;
import io.vavr.control.Option;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * Action Payload 参数解析器
 *
 * @author <a href="mailto:git@krun.dev">Jiankun-Zhang</a>
 * @since 2022/4/14
 */
public class MessagePayloadArgumentResolver implements ArgumentResolver {

    /**
     * 尝试解析给定参数.
     *
     * @param message   消息实例.
     * @param state     状态实例.
     * @param parameter 参数实例.
     * @return 解析成功时返回 {@link Option#some(Object)}, 否则返回 {@link Option#none()}
     */
    @Override
    public @NotNull Option<Object> resolve(@NotNull Message message, @NotNull Map<String, Object> state, @NotNull Parameter parameter) {
        if (parameter.getType().equals(message.getPayload().getClass())) {
            return Option.some(message.getPayload());
        }
        return Option.none();
    }

}
