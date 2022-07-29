package main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class BetManager {

    List<Betting> list = new ArrayList<>();
    static JDA jda = Main.jda;

    static class Betting {
        TextChannel channel;
        Message embed;
        Map<Member, Long> opt1 = new HashMap<>();
        Map<Member, Long> opt2 = new HashMap<>();

        public TextChannel getChannel() {
            return channel;
        }

        public Betting(TextChannel channel ,String title, String opt1, String opt2, int time) {
            this.channel = channel;
            if(time > 0){
                Message Message;
                Message = channel.sendMessageFormat("투표가 %d초 후에 시작합니다!", time).complete();
                Message.delete().queueAfter(time+1, TimeUnit.SECONDS);
                Message.editMessageFormat("투표가 %d초 후에 시작합니다!", time).queue();
                Message finalMessage = Message;
                IntStream.range(0, time).forEach(value -> finalMessage.editMessageFormat("투표가 %d초 후에 시작합니다!", value).queueAfter(time-value, TimeUnit.SECONDS));
            }

            EmbedBuilder builder = new EmbedBuilder();
            builder.setTitle(title);
            builder.addField(opt1, """
                    0 <:user:1002607879636910090>
                    0%
                    0 <:coin:1002608441791090718>
                    1 : 0
                    """, true);
            builder.addField(opt2, """
                    0 <:user:1002607879636910090>
                    0%
                    0 <:coin:1002608441791090718>
                    1 : 0
                    """, true);
            embed = channel.sendMessageEmbeds(builder.build()).complete();
        }

        private void update(){

        }

        public void add(Member m, Long point, int opt){
            Map<Member, Long> map = opt==1 ? opt1 : opt2;
            
        }
    }



    public boolean start(TextChannel channel, String title, String opt1, String opt2, int time){
        if (list.stream().anyMatch(betting -> betting.channel.equals(channel))) return false;
        list.add(new Betting(channel, title, opt1, opt2, time));
        return true;
    }




}
