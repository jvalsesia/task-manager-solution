export interface TaskDto {
    id: string;
    title: string;
    description: string;
    completed: boolean;
}


export interface TaskPayload {
    title: string;
    description: string;
    completed: boolean;
}

export interface CompleteDto {
    id: string;
    taskfound: boolean;
    completed: boolean;
}
