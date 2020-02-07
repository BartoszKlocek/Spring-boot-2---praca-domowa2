package com.example.homeworkweek2.homework;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("Plus")
public class ShopPlusService extends ShopStartService {
}
