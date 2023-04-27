package com.tp_integrador_argprograma.demo.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import com.tp_integrador_argprograma.demo.model.Team;
import com.tp_integrador_argprograma.demo.service.TeamService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamControllerTest {

    @InjectMocks
    TeamController controller;

    @Mock
    TeamService service;

    @Test
    public void getTeams(){
        Team team1 = new Team("boca","club");
        Team team2 = new Team("river","club");
        List<Team> list = new ArrayList<>();
        Collections.addAll(list, team1,team2);

        service.saveTeam(team1);
        service.saveTeam(team2);
        when(service.getTeams()).thenReturn(list);
        assert controller.getTeams().getBody() == list;
    }

    @Test
    public void saveTeam(){
        Team team = new Team("boca","club");
        when(service.saveTeam(team)).thenReturn(team);
        assertEquals(controller.saveTeam(team).getBody(),team);
    }

    @Test
    public void deleteTeam(){
        Team team = new Team("boca","club");
        service.saveTeam(team);
        when(service.deleteTeam(team.getTeamId())).thenReturn(true);
        assertTrue(controller.deleteTeam(team.getTeamId()).getBody());
    }
}
