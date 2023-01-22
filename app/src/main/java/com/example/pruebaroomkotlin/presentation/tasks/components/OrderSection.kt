package com.example.pruebaroomkotlin.presentation.tasks.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pruebaroomkotlin.feature_tareas.domain.util.OrderType
import com.example.pruebaroomkotlin.feature_tareas.domain.util.TaskOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    taskOrder: TaskOrder = TaskOrder.Timestamp(OrderType.Descending),
    onOrderChange: (TaskOrder) -> Unit,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = taskOrder is TaskOrder.Name,
                onSelect = { onOrderChange(TaskOrder.Name(taskOrder.orderType)) },
            )
            Spacer(
                modifier = Modifier.width(8.dp),
            )
            DefaultRadioButton(
                text = "Timestamp",
                selected = taskOrder is TaskOrder.Timestamp,
                onSelect = { onOrderChange(TaskOrder.Timestamp(taskOrder.orderType)) },
            )
            Spacer(
                modifier = Modifier.width(8.dp),
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                DefaultRadioButton(
                    text = "Ascending",
                    selected = taskOrder.orderType is OrderType.Ascending,
                    onSelect = { onOrderChange(taskOrder.copy(OrderType.Ascending)) },
                )
                Spacer(
                    modifier = Modifier.width(8.dp),
                )
                DefaultRadioButton(
                    text = "Descending",
                    selected = taskOrder.orderType is OrderType.Descending,
                    onSelect = { onOrderChange(taskOrder.copy(OrderType.Descending)) },
                )
                Spacer(
                    modifier = Modifier.width(8.dp),
                )
            }
        }
    }
}