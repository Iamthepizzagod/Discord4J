/*
 * This file is part of Discord4J.
 *
 * Discord4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Discord4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */
package discord4j.common.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import discord4j.common.jackson.DiscordPojoFilter;
import discord4j.common.jackson.Possible;

/**
 * Represents a Gateway Response Object as defined by Discord.
 *
 * @see <a href="https://discordapp.com/developers/docs/topics/gateway#get-gateway-bot-example-response">Gateway Response Object</a>
 */
@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = DiscordPojoFilter.class)
public class GatewayPojo {

	private String url;
	private Possible<Integer> shards = Possible.absent();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Possible<Integer> getShards() {
		return shards;
	}

	public void setShards(Possible<Integer> shards) {
		this.shards = shards;
	}
}
